# UnoGame

## Descripción del Proyecto
**UnoGame** es una versión digital del popular juego de cartas UNO. El proyecto está diseñado para proporcionar una experiencia de juego divertida y accesible para un solo jugador (contra IA) o multijugador (local y en línea).  

## Objetivos
- Implementar las reglas oficiales de UNO.
- Crear un sistema multijugador (local y en línea).
- Diseñar una interfaz gráfica intuitiva y atractiva.
- Garantizar el rendimiento y la estabilidad en diferentes dispositivos.

---

## Características
- **Modo Individual:** Juega contra una IA adaptable.
- **Multijugador Local:** Compite con amigos en el mismo dispositivo.
- **Multijugador en Línea:** Juega con personas alrededor del mundo.
- **Interfaz Gráfica:** Diseño interactivo y amigable.
- **Cumplimiento de Reglas:** Compatible con las reglas oficiales de UNO.

---

## Estructura del Proyecto
```plaintext
unoGame/
├── src/
│   ├── model/        # Lógica del juego (cartas, reglas, jugadores, mazo)
│   ├── view/         # Interfaz gráfica (JavaFX o Swing)
│   └── controller/   # Controladores para manejar la lógica y la vista
├── resources/        # Archivos multimedia (imágenes, sonidos)
└── test/             # Pruebas unitarias e integración
