# SharedPreferencesHelper
SharedPreferencesHelper maneja las preferencias locales compartidas en nuestra Aplicación Android.

Shared Preferences(SP) es una de las opciones de persistencia de datos en Android que te permite almacenar  en tuplas, es decir ``` <Key, Value> ```, elementos  primitivos como String, Boolean,Double o  Integer. Por ejemplo para guardar el email o id del usuario al autenticarse , el puntaje obtenido o alguna opción seleccionada que necesitemos usar luego en nuestra App.

## El problema

He visto en algunas oportunidades que en el Activity o Fragment invocan el sharedpreferences , realizan operaciones como guardar , editar o eliminar algún valor . Este  código suelto, repetitivo , difícil de encontrar,  cuando necesitemos hacer cambios, con el tiempo nos puede generar errores. Además,  sería una responsabilidad adicional que agregaríamos a la vista, lo cual no es correcto.

Un ejemplo : 
```
  private void saveEmail(String email){
    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("myEmail", email);
    editor.commit();
  }
```

## Una solución

Seria genial tener un clase  con la responsabilidad de manejar las operaciones del sharedpreferences y que podamos probar con test cases. A este clase la llamaré SharedPreferencesHelper. 

¿Qué responsabilidades tendría?
  - Limpiar el SP
  - Agregar algún ``` <Key, Value> ```
  - Editar algún ``` <Key, Value> ```
  - Obtener algún ``` <Key, Value> ```

Hagamos un Test Case :
Para esto voy a usar mockito , donde  probaremos guardar un String (email) y obtener el valor guardado.

## Conclusión

Siempre es sano usar helpers que nos ayuden en tareas rutinarias,con responsabilidades definidas , que podamos probar y mantener código ordenado y limpio. No recomiendo usar statics, ya saben… , es la soluciòn fácil y podría ocultar dependencias que no ayuda con el testing.

References :

- [https://developer.android.com/training/basics/data-storage/shared-preferences.html](https://developer.android.com/training/basics/data-storage/shared-preferences.html)

- [https://developer.android.com/reference/android/content/SharedPreferences.html](https://developer.android.com/reference/android/content/SharedPreferences.html)
