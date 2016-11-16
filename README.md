# sharedpreferenceshelper
SharedPreferencesHelper manages a local shared preferences in Android App

Shared Preferences(SP) es una de las opciones de persistencia de datos en Android que te permite almacenar  en tuplas, es decir <Key, Value>, elementos  primitivos como String, Boolean,Double o  Integer. Por ejemplo para guardar el email o id de usuario al autenticarse , el puntaje obtenido o alguna opciòn seleccionada que necesitemos usar luego en nuestra App.

## El problema

He visto en algunas oportunidades que en el Activity o Fragment invocan el sharedpreferences , realizan operaciones de  guardar , editar o eliminar algùn valor . Esto  còdigo suelto, repetitivo , posiblemente difícil de encontrar cuando necesitemos hacer cambios y  que pueda generar errores con el tiempo , aparte es una  responsabilidad más que agregamos a la vista, lo cual no es correcto.

```
  private void saveEmail(String email){
    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putInt("myEmail", email);
    editor.commit();
  }
```

## Una solución

Seria genial tener un clase que tenga la responsabilidad de manejar las operaciones del sharedpreferences y que nos podamos probar usando  test cases. A este clase la llamaré SharedPreferencesHelper. 

¿Què responsabilidades tendrìa?
  - Limpiar el SP
  - Agregar algùn <Key, Value>
  - Editar algùn <Key, Value>
  - Obtener algùn <Key, Value>


References :

- [https://developer.android.com/training/basics/data-storage/shared-preferences.html](https://developer.android.com/training/basics/data-storage/shared-preferences.html)

- [https://developer.android.com/reference/android/content/SharedPreferences.html](https://developer.android.com/reference/android/content/SharedPreferences.html)
