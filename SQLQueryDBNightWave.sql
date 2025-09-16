-- ======================================
-- 1) Tabla Roles
-- ======================================
CREATE TABLE roles (
  id_rol SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL UNIQUE,
  descripcion TEXT
);

-- ======================================
-- 2) Usuarios
-- ======================================
CREATE TABLE usuarios (
  id_usuario SERIAL PRIMARY KEY,
  id_rol INT NOT NULL,
  nombre_completo VARCHAR(100) NOT NULL,
  correo_electronico VARCHAR(100) UNIQUE NOT NULL,
  contrasenia VARCHAR(255) NOT NULL,
  fecha_nacimiento DATE,
  departamento VARCHAR(50),
  distrito VARCHAR(50),
  telefono VARCHAR(20),
  zona_horaria VARCHAR(50) DEFAULT 'America/Lima',
  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ultimo_acceso TIMESTAMP,
  CONSTRAINT fk_usuarios_roles FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);

-- ======================================
-- 3) Sonidos
-- ======================================
CREATE TABLE sonidos (
  id_sonido SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('musica','relajante','ambiental','alarma')),
  url_archivo VARCHAR(255) NOT NULL,
  duracion INT
);

-- ======================================
-- 4) Integraciones
-- ======================================
CREATE TABLE integraciones (
  id_integracion SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  dispositivo VARCHAR(100),
  tipo VARCHAR(20) CHECK (tipo IN ('smartwatch','app_salud','otro')),
  estado BOOLEAN DEFAULT FALSE,
  fecha_sincronizacion TIMESTAMP,
  CONSTRAINT fk_integraciones_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 5) PerfilesSuenio
-- ======================================
CREATE TABLE perfiles_suenio (
  id_perfil SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  horas_promedio DECIMAL(4,2),
  nivel_estres SMALLINT CHECK (nivel_estres BETWEEN 1 AND 5),
  cafeina_noche BOOLEAN DEFAULT FALSE,
  actividad_fisica BOOLEAN DEFAULT FALSE,
  necesidades TEXT,
  metodos_favoritos TEXT,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_perfiles_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 6) Recomendaciones
-- ======================================
CREATE TABLE recomendaciones (
  id_recomendacion SERIAL PRIMARY KEY,
  id_usuario INT,
  tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('nutricion','respiracion','ejercicio','rutina','tecnica','higiene','temperatura')),
  descripcion TEXT NOT NULL,
  fecha_generada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  vigencia_dias INT,
  CONSTRAINT fk_recomendaciones_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 7) Meditaciones
-- ======================================
CREATE TABLE meditaciones (
  id_meditacion SERIAL PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  descripcion TEXT,
  duracion INT,
  nivel_dificultad VARCHAR(10) CHECK (nivel_dificultad IN ('baja','media','alta')),
  id_sonido INT,
  categoria VARCHAR(20) CHECK (categoria IN ('insomnio','relajacion','respiracion','guiada')),
  CONSTRAINT fk_meditaciones_sonidos FOREIGN KEY (id_sonido) REFERENCES sonidos(id_sonido)
);

-- ======================================
-- 8) Recompensas
-- ======================================
CREATE TABLE recompensas (
  id_recompensa SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  descripcion TEXT,
  fecha_obtenido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  puntos INT DEFAULT 0,
  CONSTRAINT fk_recompensas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 9) ObjetivosSuenio
-- ======================================
CREATE TABLE objetivos_suenio (
  id_objetivo SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  descripcion VARCHAR(255),
  meta_horas DECIMAL(4,2),
  fecha_inicio DATE,
  fecha_fin DATE,
  cumplido BOOLEAN DEFAULT FALSE,
  CONSTRAINT fk_objetivos_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 10) Alarmas
-- ======================================
CREATE TABLE alarmas (
  id_alarma SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  hora_alarma TIME NOT NULL,
  id_sonido INT,
  dias_activos VARCHAR(50),
  activa BOOLEAN DEFAULT TRUE,
  CONSTRAINT fk_alarmas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
  CONSTRAINT fk_alarmas_sonidos FOREIGN KEY (id_sonido) REFERENCES sonidos(id_sonido)
);

-- ======================================
-- 11) Recordatorios
-- ======================================
CREATE TABLE recordatorios (
  id_recordatorio SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('dormir','cafeina','rutina','actividad')),
  mensaje VARCHAR(255),
  hora_programada TIME,
  activo BOOLEAN DEFAULT TRUE,
  CONSTRAINT fk_recordatorios_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 12) RegistrosSuenio
-- ======================================
CREATE TABLE registros_suenio (
  id_registro SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  fecha_registro DATE NOT NULL,
  hora_inicio TIMESTAMP,
  hora_fin TIMESTAMP,
  calidad_suenio SMALLINT CHECK (calidad_suenio BETWEEN 1 AND 10),
  cantidad_despertares_nocturnos INT DEFAULT 0,
  id_integracion INT,
  calificacion VARCHAR(20) NOT NULL CHECK (calificacion IN ('muy malo','malo','regular','bueno','muy bueno')),
  CONSTRAINT fk_registros_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
  CONSTRAINT fk_registros_integraciones FOREIGN KEY (id_integracion) REFERENCES integraciones(id_integracion)
);

-- ======================================
-- 13) HistorialAcceso
-- ======================================
CREATE TABLE historial_acceso (
  id_acceso SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  ip_acceso VARCHAR(50),
  dispositivo VARCHAR(100),
  fecha_acceso TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  exitoso BOOLEAN DEFAULT TRUE,
  CONSTRAINT fk_historial_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 14) ControlParental
-- ======================================
CREATE TABLE control_parental (
  id_control SERIAL PRIMARY KEY,
  id_padre INT NOT NULL,
  id_hijo INT NOT NULL,
  restricciones TEXT,
  fecha_asignacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_control_padre FOREIGN KEY (id_padre) REFERENCES usuarios(id_usuario),
  CONSTRAINT fk_control_hijo FOREIGN KEY (id_hijo) REFERENCES usuarios(id_usuario)
);

-- ======================================
-- 15) Configuracion
-- ======================================
CREATE TABLE configuracion (
  id_configuracion SERIAL PRIMARY KEY,
  id_usuario INT NOT NULL,
  modo_sin_distracciones BOOLEAN DEFAULT FALSE,
  modo_nocturno BOOLEAN DEFAULT FALSE,
  modo_avion BOOLEAN DEFAULT FALSE,
  CONSTRAINT fk_configuracion_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

INSERT INTO roles (nombre, descripcion) VALUES
('admin', 'Administrador del sistema'),
('usuario', 'Usuario estándar de la aplicación'),
('moderador', 'Usuario con permisos intermedios');

Select* from roles

INSERT INTO usuarios (id_rol, nombre_completo, correo_electronico, contrasenia, fecha_nacimiento, departamento, distrito, telefono)
VALUES
(1, 'Juan Pérez', 'juan.perez@example.com', '123456', '1990-05-15', 'Lima', 'San Isidro', '987654321'),
(2, 'María López', 'maria.lopez@example.com', 'abcdef', '1995-08-20', 'Lima', 'Miraflores', '998877665'),
(2, 'Carlos Ramírez', 'carlos.ramirez@example.com', 'qwerty', '1988-11-10', 'Cusco', 'Cusco', '912345678'),
(3, 'Ana Torres', 'ana.torres@example.com', 'zxcvb', '1992-03-25', 'Arequipa', 'Cercado', '934567890'),
(1, 'Pedro Gómez', 'pedro.gomez@example.com', 'pass123', '1985-01-05', 'Lima', 'La Molina', '945612378');

Select * from usuarios

INSERT INTO sonidos (nombre, tipo, url_archivo, duracion) VALUES
('Despertador clásico', 'alarma', 'https://example.com/sonidos/despertador.mp3', 30),
('Olas del mar', 'relajante', 'https://example.com/sonidos/olas.mp3', 120),
('Campanas suaves', 'alarma', 'https://example.com/sonidos/campanas.mp3', 45),
('Lluvia ligera', 'ambiental', 'https://example.com/sonidos/lluvia.mp3', 180);

Select * from sonidos

INSERT INTO configuracion (id_usuario, modo_sin_distracciones, modo_nocturno, modo_avion) VALUES
(1, TRUE, FALSE, FALSE),
(2, FALSE, TRUE, FALSE),
(3, FALSE, FALSE, TRUE);

Select * from configuracion

INSERT INTO control_parental (id_padre, id_hijo, restricciones) VALUES
(1, 2, 'Restringido acceso a redes sociales de 22:00 a 06:00'),
(1, 3, 'Tiempo de pantalla máximo 2 horas diarias');

Select * from control_parental

INSERT INTO alarmas (id_usuario, hora_alarma, id_sonido, dias_activos, activa) VALUES
(2, '07:00:00', 1, 'Lunes,Martes,Miercoles,Jueves,Viernes', TRUE),
(2, '09:30:00', 2, 'Sabado,Domingo', TRUE),
(3, '06:45:00', 3, 'Lunes,Miercoles,Viernes', FALSE);

Select * from alarmas