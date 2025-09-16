-- Datos de ejemplo para el esquema con relaciones
-- Primero autores
INSERT INTO authors (id, name, email) VALUES (1, 'Angel', 'angel@example.com');
INSERT INTO authors (id, name, email) VALUES (2, 'Juan', 'juan@example.com');

-- Luego posteos referenciando author_id
INSERT INTO posteos (id, titulo, author_id) VALUES (1, 'Primer post', 1);
INSERT INTO posteos (id, titulo, author_id) VALUES (2, 'Aprendiendo Spring', 2);

-- Comentarios para un post
INSERT INTO comments (text, created_at, post_id) VALUES ('Muy buen post', CURRENT_TIMESTAMP, 1);
INSERT INTO comments (text, created_at, post_id) VALUES ('Gracias por compartir', CURRENT_TIMESTAMP, 1);
