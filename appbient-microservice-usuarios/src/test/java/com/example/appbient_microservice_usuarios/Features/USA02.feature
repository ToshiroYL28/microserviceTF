Feature: Crear Ong

  Scenario Outline: El Usuario realiza correctamente la creacion de una ONG
  Given el usuario se encuentra en el formulario de registro
  When complete el formulario con nombre <nombre>, descripcion <descripcion> y local <locals>
  And le de click al boton de crear ONG
  Then se mostrar el mensaje "se creo la ONG exitosamente"

    Examples:
      | OngId | Name     | Descripcion            | Local                           |
      | 1     | "Rotary" | "Rotary International" | "av.costa sol 123, Lima, Peru"  |
      | 2     | "Red"    | "Red de Apoyo"         | "av.luna llena 232, Lima, Peru" |

  Scenario Outline: El Usuario no puede crear correctamente la ONG
  Given el usuario se encuentra en el formulario de registro
  When complete el formulario con nombre <nombre>, descripcion <descripcion> y local <locals>
  And le de click al boton de crear ONG
  Then se mostrar el mensaje "El nombre de esa ONG, ya esta en Uso"
    Examples:
      | mensaje                                      |
      | "El nombre de esa ONG, ya esta en Uso" |
      |                                              |