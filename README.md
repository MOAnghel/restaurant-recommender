# Restaurant Recommendation System

A restaurant recommendation web application that combines **collaborative filtering** with **LLM-powered sentiment analysis** to provide personalized, transparent recommendations.

## Features

- **Intelligent Chat Interface**: Natural language conversations to understand user preferences
- **Hybrid Recommendation Engine**: Combines collaborative filtering with content-based filtering
- **LLM-Powered Analysis**: Uses Google Gemini API for sentiment analysis and explanation generation
- **Transparent Recommendations**: Clear explanations for why each restaurant is recommended
- **Secure Authentication**: Keycloak-based OAuth 2.0/OpenID Connect
- **Modern UI/UX**: Responsive Next.js frontend with Tailwind CSS

## Tech Stack

### Backend
- Java 17 + Spring Boot 3
- Spring Security with Keycloak (OAuth 2.0 / OpenID Connect)
- PostgreSQL 16
- Spring Data JPA + Flyway migrations
- Maven

### Frontend
- Next.js 14 + React 18
- TypeScript
- Tailwind CSS

### Infrastructure
- Docker & Docker Compose
- Keycloak for authentication

## Getting Started

### Prerequisites

- Java 17+
- Node.js 18+
- Docker and Docker Compose
- Google Gemini API key (for AI features)

### Quick Start

1. **Clone the repository**
   ```bash
   cd restaurant-recommender
   ```

2. **Start the infrastructure (PostgreSQL + Keycloak)**
   ```bash
   docker-compose up -d
   ```

3. **Configure environment variables**
   ```bash
   cp .env.example .env
   # Edit .env with your values (especially GEMINI_API_KEY)
   ```

4. **Start the backend**
   ```bash
   cd backend/restaurant-recommender
   ./mvnw spring-boot:run
   ```

5. **Start the frontend** (in a new terminal)
   ```bash
   cd frontend/restaurant-frontend
   npm install
   npm run dev
   ```

6. **Access the application**
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080/api
   - Keycloak Admin: http://localhost:8180 (admin/admin123)

## Project Structure

```
restaurant-recommender/
├── backend/
│   └── restaurant-recommender/
│       ├── src/main/java/com/restaurant/recommender/
│       │   ├── model/          # JPA entities
│       │   ├── repository/     # Spring Data repositories
│       │   └── RestaurantRecommenderApplication.java
│       └── src/main/resources/
│           ├── application.properties
│           └── db/migration/   # Flyway migrations
├── frontend/
│   └── restaurant-frontend/
│       ├── app/                # Next.js app directory
│       └── public/             # Static assets
├── docker-compose.yml          # Docker orchestration
├── .env.example                # Environment variables template
└── PROJECT_PLAN.md             # Detailed project plan
```

## Database Schema

The application uses the following tables:
- `users` - User accounts (synced with Keycloak)
- `restaurants` - Restaurant information
- `user_preferences` - User preferences extracted from chat
- `interactions` - User-restaurant interactions (views, ratings, etc.)
- `chat_messages` - Chat conversation history
- `recommendations` - Generated recommendations with explanations

## Configuration

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `GEMINI_API_KEY` | Google Gemini API key | `demo` |
| `SPRING_DATASOURCE_URL` | PostgreSQL connection URL | `jdbc:postgresql://localhost:5432/restaurant_recommender` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `admin` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `admin123` |
| `KEYCLOAK_URL` | Keycloak server URL | `http://localhost:8180` |

## Development

### Running Tests
```bash
cd backend/restaurant-recommender
./mvnw test
```

### Building for Production
```bash
# Backend
cd backend/restaurant-recommender
./mvnw clean package

# Frontend
cd frontend/restaurant-frontend
npm run build
```

## License

This project is part of a thesis research project. See the PROJECT_PLAN.md for details.