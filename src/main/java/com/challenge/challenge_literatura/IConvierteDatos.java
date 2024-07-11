package com.challenge.challenge_literatura;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
