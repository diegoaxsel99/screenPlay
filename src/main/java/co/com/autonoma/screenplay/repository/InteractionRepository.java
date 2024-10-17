package co.com.autonoma.screenplay.repository;

import java.util.Map;

public interface InteractionRepository<T> {

    /**
     * Método para hacer clic en un botón.
     *
     * @param button El localizador del botón
     * @return Un vacio
     */
    void clickButton(T button);

    /**
     * Método para llenar un campo.
     *
     * @param field El localizador del campo
     * @param data  Los datos que se van a ingresar
     * @param <E>   El tipo de datos que se ingresará en el campo
     * @return Un vacio
     */
    <E> void fillField(T field, E data);

    /**
     * Método para manejar una alerta en la página.
     *
     * @return un vacio
     */
    void alert();

    /**
     * Método para llenar un formulario utilizando un objeto de datos y mapeo de campos.
     *
     * @param form          El objeto que contiene los datos del formulario
     * @param fieldMappings Un mapa que asocia los nombres de los campos con los localizadores
     * @param <E>           El tipo de datos del formulario
     * @return Una interacción que representa llenar el formulario
     */
    <E> void fillForm(E form, Map<String, T> fieldMappings);
}