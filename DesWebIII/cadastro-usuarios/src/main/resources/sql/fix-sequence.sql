-- Script para corrigir a sequência do autoincrement
-- Execute este script sempre que inserir dados manualmente no banco

-- Para H2 Database (padrão do Spring Boot)
ALTER SEQUENCE usuario_sequence RESTART WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM usuario);

-- Para MySQL (se estiver usando MySQL)
-- ALTER TABLE usuario AUTO_INCREMENT = (SELECT COALESCE(MAX(id), 0) + 1 FROM usuario);

-- Para PostgreSQL (se estiver usando PostgreSQL)
-- SELECT setval('usuario_sequence', COALESCE(MAX(id), 1)) FROM usuario;