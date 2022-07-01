Feature: Comentar una publicacion
  Scenario Outline: El voluntario realiza un comentario en una publicacion
    Given el voluntario se encuentra en el cuadro de texto del <foro> que desea comentar
    When el voluntario rellene el cuadro con su <comentario>
    And le de click en el boton de comentar
    Then el voluntario vera un mensaje de "comentario realizado con exito!"
    Examples:
      | foro | comentario          |
      | "1"  | "Primer comentario" |

  Scenario Outline: El voluntario no realiza un comentario en una publicacion con exito
    Given el voluntario se encuentra en el cuadro de texto del <foro> que desea comentar
    When el voluntario rellene el cuadro con su <comentario>
    And le de click en el boton de comentar
    Then el voluntario vera un mensaje de "no se puede realizar el comentario, intente mas tarde"
    Examples:
      | foro | comentario                     |
      | "2"  | "Segundo comentario con error" |