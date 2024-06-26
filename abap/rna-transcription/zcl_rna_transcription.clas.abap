CLASS zcl_rna_transcription DEFINITION
  PUBLIC
  FINAL
  CREATE PUBLIC.

  PUBLIC SECTION.
    METHODS
      transcribe
        IMPORTING
          strand             TYPE string
        RETURNING
          VALUE(result)      TYPE string.

  PROTECTED SECTION.
  PRIVATE SECTION.

ENDCLASS.


CLASS zcl_rna_transcription IMPLEMENTATION.

  METHOD transcribe.
    REPLACE ALL OCCURENCES OF 'G' WITH 'X' INTO strand.
    REPLACE ALL OCCURENCES OF 'C' WITH 'G' INTO strand.
    REPLACE ALL OCCURENCES OF 'T' WITH 'Y' INTO strand.
    REPLACE ALL OCCURENCES OF 'A' WITH 'U' INTO strand.
    REPLACE ALL OCCURENCES OF 'X' WITH 'C' INTO strand.
    REPLACE ALL OCCURENCES OF 'Y' WITH 'A' INTO strand.

    result = strand.
  ENDMETHOD.

ENDCLASS.
