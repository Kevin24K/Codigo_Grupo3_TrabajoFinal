-- ======================================
-- 1) Usuarios
-- ======================================
CREATE TABLE Usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) UNIQUE NOT NULL,
    contrasenia VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    departamento VARCHAR(50),
    distrito VARCHAR(50),
    telefono VARCHAR(20),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultimo_acceso TIMESTAMP
);

-- ======================================
-- 2) Sonidos
-- ======================================
CREATE TABLE Sonidos (
    id_sonido SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('musica','relajante','ambiental','alarma')),
    url_archivo VARCHAR(255) NOT NULL,
    duracion INT -- segundos
);

-- ======================================
-- 3) Integraciones
-- ======================================
CREATE TABLE Integraciones (
    id_integracion SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    dispositivo VARCHAR(100),
    tipo VARCHAR(20) CHECK (tipo IN ('smartwatch','app_salud','otro')),
    estado BOOLEAN DEFAULT FALSE,
    fecha_sincronizacion TIMESTAMP,
    CONSTRAINT FK_Integraciones_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 4) PerfilesSuenio
-- ======================================
CREATE TABLE PerfilesSuenio (
    id_perfil SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    horas_promedio DECIMAL(4,2),
    nivel_estres SMALLINT CHECK (nivel_estres BETWEEN 1 AND 5),
    cafeina_noche BOOLEAN DEFAULT FALSE,
    actividad_fisica BOOLEAN DEFAULT FALSE,
    necesidades TEXT,
    metodos_favoritos TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_PerfilesSuenio_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 5) Recomendaciones
-- ======================================
CREATE TABLE Recomendaciones (
    id_recomendacion SERIAL PRIMARY KEY,
    id_usuario INT,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('nutricion','ejercicio','rutina','tecnica','higiene','otro')),
    descripcion TEXT NOT NULL,
    fecha_generada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    vigencia_dias INT,
    CONSTRAINT FK_Recomendaciones_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 6) Meditaciones
-- ======================================
CREATE TABLE Meditaciones (
    id_meditacion SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    duracion INT, -- minutos
    nivel_dificultad VARCHAR(10) CHECK (nivel_dificultad IN ('baja','media','alta')),
    id_sonido INT,
    categoria VARCHAR(20) CHECK (categoria IN ('insomnio','relajacion','respiracion','guiada')),
    CONSTRAINT FK_Meditaciones_Sonidos FOREIGN KEY (id_sonido) REFERENCES Sonidos(id_sonido)
);

-- ======================================
-- 7) Recompensas
-- ======================================
CREATE TABLE Recompensas (
    id_recompensa SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    descripcion TEXT,
    fecha_obtenido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    puntos INT DEFAULT 0,
    CONSTRAINT FK_Recompensas_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 8) ObjetivosSuenio
-- ======================================
CREATE TABLE ObjetivosSuenio (
    id_objetivo SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    descripcion VARCHAR(255),
    meta_horas DECIMAL(4,2),
    fecha_inicio DATE,
    fecha_fin DATE,
    cumplido BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_ObjetivosSuenio_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 9) Alarmas
-- ======================================
CREATE TABLE Alarmas (
    id_alarma SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    hora_alarma TIME NOT NULL,
    id_sonido INT,
    dias_activos VARCHAR(50),
    activa BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_Alarmas_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    CONSTRAINT FK_Alarmas_Sonidos FOREIGN KEY (id_sonido) REFERENCES Sonidos(id_sonido)
);

-- ======================================
-- 10) Recordatorios
-- ======================================
CREATE TABLE Recordatorios (
    id_recordatorio SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('dormir','cafeina','rutina','actividad')),
    mensaje VARCHAR(255),
    hora_programada TIME,
    activo BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_Recordatorios_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- ======================================
-- 11) RegistrosSuenio
-- ======================================
CREATE TABLE RegistrosSuenio (
    id_registro SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha_registro DATE NOT NULL,
    hora_inicio TIMESTAMP,
    hora_fin TIMESTAMP,
    duracion_horas DECIMAL(4,2),
    calidad_sueno SMALLINT CHECK (calidad_sueno BETWEEN 1 AND 10),
    cantidad_despertares_nocturnos INT DEFAULT 0,
    id_integracion INT,
    CONSTRAINT FK_RegistrosSuenio_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    CONSTRAINT FK_RegistrosSuenio_Integraciones FOREIGN KEY (id_integracion) REFERENCES Integraciones(id_integracion)
);

-- ======================================
-- 12) HistorialAcceso
-- ======================================
CREATE TABLE HistorialAcceso (
    id_acceso SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    ip_acceso VARCHAR(50),
    dispositivo VARCHAR(100),
    fecha_acceso TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    exitoso BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_HistorialAcceso_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);
