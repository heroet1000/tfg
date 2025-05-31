-- Insertar usuario admin con campos NULL
INSERT IGNORE INTO user (id,ap1,ap2,cod_postal,direccion,email,enabled,nombre,numero,password,piso,username)
SELECT 
    null,
    null,
    null,
    null,
    null,
    null,
    true,
    null,
    null,
    "$2a$10$5cIyWt4EBO3iTE7JY8EgV.oa5UKYmWQ/ZX4F0D1lw205EzVR2tTDO", -- admin123
    null,
    'admin'
    
WHERE NOT EXISTS (SELECT 1 FROM user WHERE username = 'admin');

-- Insertar rol
INSERT INTO user_roles (user_id, roles)
SELECT u.id, 'ADMIN'
FROM user u
WHERE u.username = 'admin'
AND NOT EXISTS (SELECT 1 FROM user_roles WHERE user_id = u.id AND roles = 'ADMIN');