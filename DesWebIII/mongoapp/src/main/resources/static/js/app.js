// MongoApp - User Management JavaScript
class UserManager {
    constructor() {
        this.apiUrl = "http://localhost:8080/user";
        this.form = document.getElementById("userForm");
        this.table = document.getElementById("userTable");
        this.init();
    }

    init() {
        this.bindEvents();
        this.carregarUsuarios();
        this.setupFormValidation();
    }

    bindEvents() {
        this.form.addEventListener("submit", (e) => this.handleSubmit(e));
        
        // Real-time validation
        const inputs = this.form.querySelectorAll('input[type="text"], input[type="email"]');
        inputs.forEach(input => {
            input.addEventListener('blur', () => this.validateField(input));
            input.addEventListener('input', () => this.clearFieldError(input));
        });
    }

    setupFormValidation() {
        // Bootstrap validation classes
        const forms = document.querySelectorAll('.needs-validation');
        forms.forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            });
        });
    }

    validateField(field) {
        const value = field.value.trim();
        const isValid = field.checkValidity();
        
        if (!isValid || !value) {
            field.classList.add('is-invalid');
            field.classList.remove('is-valid');
        } else {
            field.classList.add('is-valid');
            field.classList.remove('is-invalid');
        }
        
        return isValid && value;
    }

    clearFieldError(field) {
        field.classList.remove('is-invalid');
        if (field.value.trim()) {
            field.classList.add('is-valid');
        } else {
            field.classList.remove('is-valid');
        }
    }

    showAlert(message, type = 'success') {
        const alertContainer = document.getElementById('alertContainer');
        const alertClass = type === 'success' ? 'alert-success-custom' : 'alert-error-custom';
        
        alertContainer.innerHTML = `
            <div class="alert alert-custom ${alertClass} alert-dismissible fade show" role="alert">
                <i class="fas fa-${type === 'success' ? 'check-circle' : 'exclamation-triangle'} me-2"></i>
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        `;
        
        // Auto dismiss after 5 seconds
        setTimeout(() => {
            const alert = alertContainer.querySelector('.alert');
            if (alert) {
                alert.remove();
            }
        }, 5000);
    }

    setLoadingState(button, loading = true) {
        if (loading) {
            button.disabled = true;
            button.dataset.originalText = button.innerHTML;
            button.innerHTML = '<i class="fas fa-spinner fa-spin me-2"></i>Processando...';
        } else {
            button.disabled = false;
            button.innerHTML = button.dataset.originalText;
        }
    }

    async carregarUsuarios() {
        const tableContainer = document.querySelector('.table-container');
        
        try {
            tableContainer.classList.add('loading');
            
            const response = await fetch(`${this.apiUrl}/listar`);
            if (!response.ok) throw new Error(`HTTP ${response.status}`);
            
            const usuarios = await response.json();
            this.renderTable(usuarios);
            
        } catch (error) {
            console.error("Erro ao carregar usuários:", error);
            this.showAlert("Erro ao carregar usuários. Verifique a conexão com o servidor.", "error");
            this.renderEmptyState("Erro ao carregar dados");
        } finally {
            tableContainer.classList.remove('loading');
        }
    }

    renderTable(usuarios) {
        if (!usuarios.length) {
            this.renderEmptyState("Nenhum usuário cadastrado");
            return;
        }

        this.table.innerHTML = usuarios.map(user => `
            <tr class="fade-in">
                <td>
                    <div class="d-flex align-items-center">
                        <div class="avatar-placeholder me-3">
                            <i class="fas fa-user"></i>
                        </div>
                        <div>
                            <strong>${this.escapeHtml(user.name)}</strong>
                        </div>
                    </div>
                </td>
                <td>
                    <span class="text-muted">
                        <i class="fas fa-envelope me-1"></i>
                        ${this.escapeHtml(user.mail)}
                    </span>
                </td>
                <td>
                    <div class="action-buttons">
                        <button class="btn btn-sm-custom btn-edit" 
                                onclick="userManager.editarUsuario('${user.id}','${this.escapeHtml(user.name)}','${this.escapeHtml(user.mail)}')"
                                title="Editar usuário">
                            <i class="fas fa-edit me-1"></i>Editar
                        </button>
                        <button class="btn btn-sm-custom btn-delete" 
                                onclick="userManager.deletarUsuario('${user.id}')"
                                title="Excluir usuário">
                            <i class="fas fa-trash me-1"></i>Excluir
                        </button>
                    </div>
                </td>
            </tr>
        `).join('');
    }

    renderEmptyState(message) {
        this.table.innerHTML = `
            <tr>
                <td colspan="3" class="empty-state">
                    <i class="fas fa-users"></i>
                    <p class="mb-0">${message}</p>
                </td>
            </tr>
        `;
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    async handleSubmit(e) {
        e.preventDefault();
        
        const submitBtn = this.form.querySelector('button[type="submit"]');
        const id = document.getElementById("userId").value;
        const nome = document.getElementById("nome").value.trim();
        const email = document.getElementById("email").value.trim();

        // Validate form
        if (!this.validateForm()) return;

        const usuario = { name: nome, mail: email };

        try {
            this.setLoadingState(submitBtn, true);

            let response;
            if (id) {
                response = await fetch(`${this.apiUrl}/${id}`, {
                    method: "PUT",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(usuario)
                });
            } else {
                response = await fetch(`${this.apiUrl}/salvar`, {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(usuario)
                });
            }

            if (!response.ok) {
                throw new Error(`HTTP ${response.status}: ${response.statusText}`);
            }

            this.showAlert(
                id ? "Usuário atualizado com sucesso!" : "Usuário criado com sucesso!",
                "success"
            );

            this.novoUsuario();
            await this.carregarUsuarios();

        } catch (error) {
            console.error("Erro ao salvar usuário:", error);
            this.showAlert("Erro ao salvar usuário. Tente novamente.", "error");
        } finally {
            this.setLoadingState(submitBtn, false);
        }
    }

    validateForm() {
        const nome = document.getElementById("nome");
        const email = document.getElementById("email");
        
        const nomeValid = this.validateField(nome);
        const emailValid = this.validateField(email);
        
        return nomeValid && emailValid;
    }

    editarUsuario(id, nome, email) {
        document.getElementById("userId").value = id;
        document.getElementById("nome").value = nome;
        document.getElementById("email").value = email;
        
        // Clear validation classes
        const inputs = this.form.querySelectorAll('.form-control');
        inputs.forEach(input => {
            input.classList.remove('is-valid', 'is-invalid');
        });

        // Scroll to form
        document.querySelector('.form-container').scrollIntoView({ 
            behavior: 'smooth' 
        });

        // Focus on nome field
        document.getElementById("nome").focus();
    }

    novoUsuario() {
        this.form.reset();
        document.getElementById("userId").value = "";
        
        // Clear validation classes
        const inputs = this.form.querySelectorAll('.form-control');
        inputs.forEach(input => {
            input.classList.remove('is-valid', 'is-invalid');
        });
        
        this.form.classList.remove('was-validated');
    }

    async deletarUsuario(id) {
        // Custom confirmation modal would be better, but using confirm for simplicity
        if (!confirm("Tem certeza que deseja excluir este usuário?")) return;

        try {
            const response = await fetch(`${this.apiUrl}/${id}`, { 
                method: "DELETE" 
            });

            if (!response.ok) {
                throw new Error(`HTTP ${response.status}`);
            }

            this.showAlert("Usuário excluído com sucesso!", "success");
            await this.carregarUsuarios();

        } catch (error) {
            console.error("Erro ao deletar usuário:", error);
            this.showAlert("Erro ao excluir usuário. Tente novamente.", "error");
        }
    }
}

// Initialize when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    window.userManager = new UserManager();
});

// Global functions for backward compatibility
function editarUsuario(id, nome, email) {
    window.userManager.editarUsuario(id, nome, email);
}

function deletarUsuario(id) {
    window.userManager.deletarUsuario(id);
}