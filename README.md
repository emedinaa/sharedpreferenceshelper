# SharedPreferencesHelper
SharedPreferencesHelper manages a local shared preferences in Android App

Shared Preferences(SP) es una de las opciones de persistencia de datos en Android que te permite almacenar  en tuplas, es decir ``` <Key, Value> ```, elementos  primitivos como String, Boolean,Double o  Integer. Por ejemplo para guardar el email o id de usuario al autenticarse , el puntaje obtenido o alguna opción seleccionada que necesitemos usar luego en nuestra App.

## El problema

He visto en algunas oportunidades que en el Activity o Fragment invocan el sharedpreferences , realizan operaciones como guardar , editar o eliminar algún valor . Este  código suelto, repetitivo , posiblemente difícil de encontrar cuando necesitemos hacer cambios, con el tiempos nos puede generar errores. Aparte sería una responsabilidad más que agregaríamos a la vista, lo cual no es correcto.

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


References :

- [https://developer.android.com/training/basics/data-storage/shared-preferences.html](https://developer.android.com/training/basics/data-storage/shared-preferences.html)

- [https://developer.android.com/reference/android/content/SharedPreferences.html](https://developer.android.com/reference/android/content/SharedPreferences.html)
