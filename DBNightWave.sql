CREATE TABLE Rol (
    id SERIAL PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_nacimiento TIMESTAMP,
    genero VARCHAR(20),
    rol_id INT REFERENCES Rol(id)
);

CREATE TABLE Tipo_Musica (
    id SERIAL PRIMARY KEY,
    nombre_tipo VARCHAR(50) NOT NULL,
    categoria VARCHAR(30),
    descripcion VARCHAR(200)
);

CREATE TABLE Musica_Multimedia (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    link_archivo VARCHAR(500) NOT NULL,
    tipo_musica_id INT REFERENCES Tipo_Musica(id)
);

CREATE TABLE Alarma (
    id SERIAL PRIMARY KEY,
    nombre_alarma VARCHAR(100) NOT NULL,
    hora_alarma TIME NOT NULL,
    dias_semana VARCHAR(50),
    volumen DOUBLE PRECISION,
    activa BOOLEAN DEFAULT TRUE,
    usuario_id INT REFERENCES Usuario(id),
    contenido_id INT REFERENCES Musica_Multimedia(id)
);

CREATE TABLE Notificacion (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    mensaje VARCHAR(500),
    tipo VARCHAR(30),
    fecha_programada TIMESTAMP,
    leida BOOLEAN DEFAULT FALSE,
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Sueno (
    id SERIAL PRIMARY KEY,
    fecha_registro TIMESTAMP,
    hora_acostarse TIMESTAMP,
    hora_despertar TIMESTAMP,
    horas_dormidas DOUBLE PRECISION,
    calidad_sueno INT,
    interrupciones INT,
    cafeina_consumida BOOLEAN,
    ejercicio_realizado BOOLEAN,
    pantallas_antes_dormir BOOLEAN,
    nivel_estres_dia INT,
    notas VARCHAR(300),
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Estres (
    id SERIAL PRIMARY KEY,
    nivel_estres INT,
    nivel_ansiedad INT,
    factores_estimulantes VARCHAR(200),
    sintomas_fisicos VARCHAR(200),
    sintomas_emocionales VARCHAR(200),
    fecha_registro TIMESTAMP,
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Actividad (
    id SERIAL PRIMARY KEY,
    tipo_actividad VARCHAR(50),
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(300),
    duracion_minutos INT,
    intensidad VARCHAR(20),
    fecha_inicio TIMESTAMP,
    fecha_fin TIMESTAMP,
    completada BOOLEAN,
    nivel_estres_antes INT,
    nivel_estres_despues INT,
    puntuacion_satisfaccion INT,
    usuario_id INT REFERENCES Usuario(id),
    musica_id INT REFERENCES Musica_Multimedia(id)
);

CREATE TABLE Habitos (
    id SERIAL PRIMARY KEY,
    nombre_habito VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300),
    categoria VARCHAR(30),
    momento_dia VARCHAR(20),
    activo BOOLEAN DEFAULT TRUE,
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Seguimiento_Habitos (
    id SERIAL PRIMARY KEY,
    completado BOOLEAN,
    calidad_ejecucion INT,
    notas VARCHAR(200),
    fecha_seguimiento TIMESTAMP,
    usuario_id INT REFERENCES Usuario(id),
    habito_id INT REFERENCES Habitos(id)
);

CREATE TABLE Objetivos (
    id SERIAL PRIMARY KEY,
    nombre_objetivo VARCHAR(200) NOT NULL,
    tipo_objetivo VARCHAR(50),
    descripcion VARCHAR(300),
    valor_objetivo DOUBLE PRECISION,
    valor_actual DOUBLE PRECISION,
    unidad_medida VARCHAR(20),
    fecha_inicio TIMESTAMP,
    fecha_fin TIMESTAMP,
    alcanzado BOOLEAN,
    fecha_logro TIMESTAMP,
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Recompensas (
    id SERIAL PRIMARY KEY,
    nombre_recompensa VARCHAR(150) NOT NULL,
    descripcion VARCHAR(300),
    tipo_recompensa VARCHAR(50),
    puntos_valor INT
);

CREATE TABLE Objetivos_Recompensas (
    id SERIAL PRIMARY KEY,
    fecha_obtencion TIMESTAMP,
    recompensa_id INT REFERENCES Recompensas(id),
    objetivo_id INT REFERENCES Objetivos(id)
);

CREATE TABLE Evaluacion_Diaria (
    id SERIAL PRIMARY KEY,
    estado_animo VARCHAR(30),
    nivel_energia INT,
    recomendaciones VARCHAR(500),
    fecha_evaluacion TIMESTAMP,
    usuario_id INT REFERENCES Usuario(id)
);

CREATE TABLE Control_Parental (
    id SERIAL PRIMARY KEY,
    usuario_padre_id INT REFERENCES Usuario(id),
    usuario_hijo_id INT REFERENCES Usuario(id),
    restricciones VARCHAR(500),
    hora_inicio TIME,
    hora_fin TIME,
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE Integracion (
    id SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES Usuario(id),
    proveedor VARCHAR(100),
    tipo VARCHAR(50),
    token_acceso VARCHAR(500),
    fecha_registro TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
);



-- ===========================
-- 1) Roles
-- ===========================
INSERT INTO Rol (nombre_rol) VALUES
('Administrador'),
('Usuario'),
('Moderador');

-- ===========================
-- 2) Usuarios
-- ===========================
INSERT INTO Usuario (nombre, apellido, email, password, fecha_nacimiento, genero, rol_id) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', '123456', '1990-05-15', 'Masculino', 1),
('María', 'López', 'maria.lopez@example.com', 'abcdef', '1995-08-20', 'Femenino', 2),
('Carlos', 'Ramírez', 'carlos.ramirez@example.com', 'qwerty', '1988-11-10', 'Masculino', 2),
('Ana', 'Torres', 'ana.torres@example.com', 'zxcvb', '1992-03-25', 'Femenino', 3);

-- ===========================
-- 3) Tipo de Música
-- ===========================
INSERT INTO Tipo_Musica (nombre_tipo, categoria, descripcion) VALUES
('Alarma', 'Notificación', 'Sonidos clásicos de alarma'),
('Relajación', 'Ambiental', 'Sonidos para relajarse y dormir'),
('Motivación', 'Energizante', 'Música motivacional para hacer ejercicio');

-- ===========================
-- 4) Música Multimedia
-- ===========================
INSERT INTO Musica_Multimedia (nombre, link_archivo, tipo_musica_id) VALUES
('Despertador clásico', 'https://example.com/sonidos/despertador.mp3', 1),
('Olas del mar', 'https://example.com/sonidos/olas.mp3', 2),
('Campanas suaves', 'https://example.com/sonidos/campanas.mp3', 1),
('Música motivacional', 'https://example.com/sonidos/motivacion.mp3', 3);

-- ===========================
-- 5) Alarmas
-- ===========================
INSERT INTO Alarma (nombre_alarma, hora_alarma, dias_semana, volumen, activa, usuario_id, contenido_id) VALUES
('Alarma trabajo', '07:00:00', 'Lunes,Martes,Miercoles,Jueves,Viernes', 0.8, TRUE, 2, 1),
('Alarma descanso', '09:30:00', 'Sabado,Domingo', 0.5, TRUE, 2, 2),
('Alarma ejercicio', '06:45:00', 'Lunes,Miercoles,Viernes', 1.0, FALSE, 3, 4);

-- ===========================
-- 6) Notificaciones
-- ===========================
INSERT INTO Notificacion (titulo, mensaje, tipo, fecha_programada, leida, usuario_id) VALUES
('Recordatorio de alarma', 'No olvides tu reunión a las 8 AM', 'Recordatorio', NOW(), FALSE, 2),
('Notificación de sueño', 'Dormiste 6 horas anoche', 'Informe', NOW(), TRUE, 3);

-- ===========================
-- 7) Sueño
-- ===========================
INSERT INTO Sueno (fecha_registro, hora_acostarse, hora_despertar, horas_dormidas, calidad_sueno, interrupciones, cafeina_consumida, ejercicio_realizado, pantallas_antes_dormir, nivel_estres_dia, notas, usuario_id) VALUES
(NOW(), '2025-09-14 23:00:00', '2025-09-15 06:00:00', 7.0, 8, 1, TRUE, TRUE, FALSE, 3, 'Buen descanso', 2),
(NOW(), '2025-09-14 22:30:00', '2025-09-15 05:30:00', 7.0, 7, 2, FALSE, TRUE, TRUE, 5, 'Me desperté varias veces', 3);

-- ===========================
-- 8) Estrés
-- ===========================
INSERT INTO Estres (nivel_estres, nivel_ansiedad, factores_estimulantes, sintomas_fisicos, sintomas_emocionales, fecha_registro, usuario_id) VALUES
(7, 5, 'Trabajo, cafeína', 'Dolor de cabeza', 'Ansiedad', NOW(), 2),
(3, 2, 'Ejercicio', 'Cansancio', 'Relajado', NOW(), 3);

-- ===========================
-- 9) Actividades
-- ===========================
INSERT INTO Actividad (tipo_actividad, nombre, descripcion, duracion_minutos, intensidad, fecha_inicio, fecha_fin, completada, nivel_estres_antes, nivel_estres_despues, puntuacion_satisfaccion, usuario_id, musica_id) VALUES
('Ejercicio', 'Correr', 'Correr en el parque', 30, 'Alta', NOW(), NOW() + INTERVAL '30 minutes', TRUE, 6, 3, 9, 2, 4),
('Relajación', 'Meditación', 'Sesión de meditación guiada', 20, 'Baja', NOW(), NOW() + INTERVAL '20 minutes', TRUE, 5, 2, 10, 3, 2);

-- ===========================
-- 10) Hábitos
-- ===========================
INSERT INTO Habitos (nombre_habito, descripcion, categoria, momento_dia, activo, usuario_id) VALUES
('Dormir temprano', 'Acostarse antes de las 11 PM', 'Salud', 'Noche', TRUE, 2),
('Ejercicio diario', 'Hacer al menos 20 minutos de ejercicio', 'Salud', 'Mañana', TRUE, 3);

-- ===========================
-- 11) Seguimiento de Hábitos
-- ===========================
INSERT INTO Seguimiento_Habitos (completado, calidad_ejecucion, notas, fecha_seguimiento, usuario_id, habito_id) VALUES
(TRUE, 9, 'Dormí temprano', NOW(), 2, 1),
(FALSE, 5, 'No hice ejercicio hoy', NOW(), 3, 2);

-- ===========================
-- 12) Objetivos
-- ===========================
INSERT INTO Objetivos (nombre_objetivo, tipo_objetivo, descripcion, valor_objetivo, valor_actual, unidad_medida, fecha_inicio, fecha_fin, alcanzado, usuario_id) VALUES
('Bajar de peso', 'Salud', 'Reducir 5 kg en 3 meses', 70, 73, 'kg', NOW(), NOW() + INTERVAL '90 days', FALSE, 2),
('Leer libros', 'Personal', 'Leer 5 libros en 2 meses', 5, 2, 'libros', NOW(), NOW() + INTERVAL '60 days', FALSE, 3);

-- ===========================
-- 13) Recompensas
-- ===========================
INSERT INTO Recompensas (nombre_recompensa, descripcion, tipo_recompensa, puntos_valor) VALUES
('Día libre', 'Un día sin trabajo', 'Tiempo libre', 100),
('Cena especial', 'Cena en un restaurante favorito', 'Premio', 150);

-- ===========================
-- 14) Objetivos_Recompensas
-- ===========================
INSERT INTO Objetivos_Recompensas (fecha_obtencion, recompensa_id, objetivo_id) VALUES
(NOW(), 1, 1),
(NOW(), 2, 2);

-- ===========================
-- 15) Evaluación Diaria
-- ===========================
INSERT INTO Evaluacion_Diaria (estado_animo, nivel_energia, recomendaciones, fecha_evaluacion, usuario_id) VALUES
('Feliz', 8, 'Sigue con el buen trabajo', NOW(), 2),
('Cansado', 4, 'Duerme más horas esta noche', NOW(), 3);

-- ===========================
-- 16) Control Parental
-- ===========================
INSERT INTO Control_Parental (usuario_padre_id, usuario_hijo_id, restricciones, hora_inicio, hora_fin, activo) VALUES
(1, 2, 'Restringido acceso a redes sociales', '22:00:00', '06:00:00', TRUE),
(1, 3, 'Tiempo de pantalla máximo 2 horas', '15:00:00', '17:00:00', TRUE);

-- ===========================
-- 17) Integración
-- ===========================
INSERT INTO Integracion (usuario_id, proveedor, tipo, token_acceso, fecha_registro, activo) VALUES
(2, 'Google Fit', 'Salud', 'token12345', NOW(), TRUE),
(3, 'Spotify', 'Música', 'token67890', NOW(), TRUE);
