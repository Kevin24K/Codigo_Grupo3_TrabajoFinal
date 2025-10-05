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
    rol_id INT REFERENCES Rol(id),
	activa BOOLEAN DEFAULT TRUE
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
