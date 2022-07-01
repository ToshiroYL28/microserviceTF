Feature: Crear publicacion en foro
  Scenario Outline: El voluntario realiza correctamente una publicacion en el foro
    Given el voluntario se encuentra en el formulario de creacion de publicacion
    When complete el formulario con nombre <nombre>, descripcion <descripcion>, voluntaioId <voluntarioId>, ongId <ongId> y topicoId <topicoId>
    And le de click al boton de crear publicacion
    Then se mostrar el mensaje "se creo publicacion exitosamente"
    Examples:
      | nombre        | descripcion  | voluntarioId | ongId | topicoId |
      | "Primer Foro" | "Hola mundo" | "1"          | ""    | "1"      |

  Scenario Outline: El voluntario no puede crear una publicacion en el foro
    Given el voluntario se encuentra en el formulario de creacion de publicacion
    When complete el formulario con nombre <nombre>, descripcion <descripcion>, voluntaioId <voluntarioId>, ongId <ongId> y topicoId <topicoId>
    And le de click al boton de crear publicacion
    Then se mostrar el mensaje "no se pudo crear la publicacion, intentelo de nuevo"
    Examples:
      | nombre        | descripcion  | voluntarioId | ongId | topicoId |
      | "Primer Foro" | "Hola mundo" | "1"          | ""    | "1"      |