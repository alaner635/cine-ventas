# 🎬 Sistema de Ventas - Cine

Sistema de gestión y ventas para un cine, desarrollado en Java con conexión a múltiples bases de datos. Permite administrar películas, salas, clientes, entradas, productos de dulcería y el punto de venta.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java (JDK 20)
- **IDE:** Apache NetBeans
- **Bases de datos:** MySQL · SQL Server · PostgreSQL
- **Librerías:**
  - `mysql-connector-java-5.1.47` — Conexión a MySQL
  - `mssql-jdbc-12.6.1.jre8` — Conexión a SQL Server
  - `postgresql-42.7.3` — Conexión a PostgreSQL
  - `jcalendar-1.3.3` — Selector de fechas
  - `DS_Desktop_Notify` — Notificaciones de escritorio
  - `TimingFramework-0.55` — Animaciones
  - `swing-time-picker` — Selector de hora

---

## 📦 Módulos del sistema

| Módulo | Descripción |
|---|---|
| 🎥 Películas | Gestión del catálogo de películas |
| 🏟️ Salas | Administración de salas del cine |
| 👤 Clientes | Registro y gestión de clientes |
| 🎟️ Entradas | Venta y control de boletos |
| 🍿 Dulcería | Gestión de productos y stock |
| 💰 Punto de Venta | Registro de ventas y transacciones |

---

## ⚙️ Configuración de bases de datos

El proyecto se conecta a tres motores de bases de datos. Configura tus credenciales en el archivo:

```
source/config.properties
```

### MySQL
```properties
mysql.url=jdbc:mysql://localhost:3306/nombre_bd
mysql.user=tu_usuario
mysql.password=tu_contraseña
```

### SQL Server
```properties
sqlserver.url=jdbc:sqlserver://localhost:1433;databaseName=nombre_bd
sqlserver.user=tu_usuario
sqlserver.password=tu_contraseña
```

### PostgreSQL
```properties
postgresql.url=jdbc:postgresql://localhost:5432/nombre_bd
postgresql.user=tu_usuario
postgresql.password=tu_contraseña
```

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/alaner635/cine-ventas.git
   ```
2. Abre el proyecto en **Apache NetBeans**
3. Configura tus credenciales en `source/config.properties`
4. Asegúrate de tener las bases de datos creadas y corriendo
5. Ejecuta el proyecto con **Run > Run Project** o `F6`

---

## 📋 Requisitos previos

- JDK 20 o superior
- Apache NetBeans
- MySQL Server
- SQL Server *(opcional, para módulos que lo requieran)*
- PostgreSQL *(opcional, para módulos que lo requieran)*
