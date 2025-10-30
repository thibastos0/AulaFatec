
    const apiUrl = "http://localhost:8080/mongoapp/product";
    const form = document.getElementById("productForm");
    const table = document.getElementById("productTable");

    // Listar usuários
    async function carregarProdutos() {
      try {
        const res = await fetch(apiUrl + "/listar");
        const produtos = await res.json();
        table.innerHTML = "";
        produtos.forEach(p => {
          const tr = document.createElement("tr");
          tr.innerHTML = `
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td class="actions">
              <button onclick="editarProduto('${p.id}','${p.name}','${p.description}','${p.price}','${p.quantity}')">Editar</button>
              <button class="delete" onclick="deletarProduto('${p.id}')">Excluir</button>
            </td>
          `;
          table.appendChild(tr);
        });
      } catch (error) {
        console.error("Erro ao carregar Produtos:", error);
      }
    }

    // Criar ou atualizar
    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      const id = document.getElementById("productId").value;
      const nome = document.getElementById("nome").value;
      const descricao = document.getElementById("descricao").value;
      const preco = document.getElementById("preco").value;
      const quantidade = document.getElementById("quantidade").value;

      const produto = { name: nome, description: descricao, price: preco, quantity: quantidade };

      try {
        if (id) {
          // Atualiza produto existente
          await fetch(`${apiUrl}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(produto)
          });
        } else {
          // Cria novo ṕroduto
          await fetch(apiUrl + "/salvar", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(produto)
          });
        }

        // Limpa formulário e atualiza tabela
        novoProduto();
        carregarProdutos();
      } catch (error) {
        console.error("Erro ao salvar produto:", error);
      }
    });

    // Editar produto
    function editarProduto(id, nome, descricao, preco, quantidade) {
      document.getElementById("productId").value = id;
      document.getElementById("nome").value = nome;
      document.getElementById("descricao").value = descricao;
      document.getElementById("preco").value = preco;
      document.getElementById("quantidade").value = quantidade;
    }

    // Limpar formulário para novo produto
    function novoProduto() {
      form.reset();
      document.getElementById("productId").value = "";
    }

    // Deletar usuário
    async function deletarProduto(id) {
      if (confirm("Deseja excluir este produto?")) {
        try {
          await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
          carregarProdutos();
        } catch (error) {
          console.error("Erro ao deletar produto:", error);
        }
      }
    }

    // Inicializa tabela
    carregarProdutos();