# 📊 Sentiment Analysis System - FullStack MVP

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=springboot&logoColor=white)](https://spring.io/)
[![Angular](https://img.shields.io/badge/Angular-17-DD0031?logo=angular&logoColor=white)](https://angular.io/)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-3.x-38B2AC?logo=tailwind-css&logoColor=white)](https://tailwindcss.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-4169E1?logo=postgresql&logoColor=white)](https://www.postgresql.org/)

Este es un sistema FullStack de análisis de sentimientos que utiliza un motor de procesamiento de lenguaje natural (NLP). El sistema permite analizar textos en tiempo real, almacenar los resultados en una base de datos relacional y visualizar métricas dinámicas con un carrusel de ejemplos aleatorios.

## 🚀 Características Principales

* **Análisis en Tiempo Real:** Interfaz intuitiva para procesar textos y obtener etiquetas de sentimiento (Positivo, Neutro, Negativo).
* **Métricas Dinámicas:** Dashboard visual que muestra el porcentaje histórico de sentimientos procesados.
* **Carrusel de Ejemplos Aleatorios:** Sistema que recupera ejemplos reales de la base de datos de forma aleatoria mediante consultas nativas SQL.
* **Estado de Conexión "Live":** Indicadores visuales (Live/Disconnected) que monitorean la disponibilidad de la API Rest.
* **Responsive Design:** Optimizado para móviles y escritorio con efectos de desenfoque (backdrop-blur) y animaciones de pulso.

## 🛠️ Stack Tecnológico

### Backend (Java)
* **Spring Boot 3:** Framework principal.
* **Spring Data JPA:** Gestión de persistencia.
* **PostgreSQL:** Base de datos relacional.
* **MapStruct:** Mapeo eficiente de entidades a DTOs.
* **Lombok:** Reducción de código boilerplate.
* **Native Queries:** Implementación de `ORDER BY RANDOM()` para aleatoriedad real.

### Frontend (Angular)
* **Angular 17:** Framework de SPA con componentes Standalone.
* **Tailwind CSS:** Estilizado moderno y responsivo.
* **RxJS:** Manejo de flujos de datos asíncronos y peticiones HTTP.
* **Lucide Icons & Emojis:** Feedback visual mejorado.

## 📦 Instalación y Configuración

### Backend
1. Clonar el repositorio.
2. Configurar el archivo `application.properties` con tus credenciales de PostgreSQL.
3. Ejecutar `./mvnw spring-boot:run`.

### Frontend
1. Navegar a la carpeta del frontend.
2. Instalar dependencias: `npm install`.
3. Iniciar servidor de desarrollo: `ng serve`.

## 📈 Roadmap / Próximas Mejoras
- [ ] Implementar autenticación con JWT.
- [ ] Exportar reportes en PDF de las métricas.
- [ ] Soporte multi-idioma para el análisis de texto.

---
Desarrollado con ❤️ para el Challenge de **Alura Latam**.

Autor: Jhony Lezama