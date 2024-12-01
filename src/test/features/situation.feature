Feature: Gestion des situations difficiles

  Background:
    Given Je déclare une nouvelle situation difficile le "2024-10-12T14:45:00Z"
    And Je déclare une nouvelle situation difficile le "2024-10-13T15:40:00Z"
    And Je déclare une nouvelle situation difficile le "2024-10-14T10:10:00Z"

  Rule: Lister les situations difficiles

    Scenario: Affichage de la liste des situations difficiles
      Then La liste de mes situation difficiles est
        | id  | Date creation        |
        | SD1 | 2024-10-12T14:45:00Z |
        | SD2 | 2024-10-13T15:40:00Z |
        | SD3 | 2024-10-14T10:10:00Z |

  Rule: Afficher le détail d'une situation difficile

    Scenario: Affichage détaillé d'une nouvelle situation difficile
      Then Le détail de la situation "SD1" est
        | id           | SD1                  |
        | dateCreation | 2024-10-12T14:45:00Z |

    Scenario: Erreur si la situation difficile n'existe pas
      Then La récupération du détail de la situation "SD99999" échoue car elle n'existe pas


  Rule: Afficher l'étape de définition d'une situation difficile

    Scenario: Erreur si la situation difficile n'existe pas
      Then La récupération de l'étape de la situation "SD99999" échoue car elle n'existe pas

    Scenario: L'étape d'une nouvelle situation est "DEFINIR_SIGNES_PHYSIOLOGIQUES"
      Then La situation "SD1" est à l'étape "DEFINIR_SIGNES_PHYSIOLOGIQUES"

    Scenario: L'étape d'une situation avec signes physiologiques définis est "DECRIRE_SITUATION"
      When Je définis les signes physiologiques de la situation "SD1" avec
        | NAUSEE   |
        | DOULEURS |
      Then La définition des signes physiologiques est valide
      And La situation "SD1" est à l'étape "DECRIRE_SITUATION"


  Rule: Définir une situation difficile

    Scenario: Définir les signes physiologiques pour une situation inconnue échoue
      When Je définis les signes physiologiques de la situation "SD99999" avec
        | NAUSEE   |
        | DOULEURS |
      Then La définition des signes physiologiques échoue car la situation est inconnue

      #TODO maj affichage détaillé
