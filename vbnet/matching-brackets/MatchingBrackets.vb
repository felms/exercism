Imports System.Collections.Generic

Public Module MatchingBrackets
    Public Function IsPaired(ByVal input As String) As Boolean

        Dim stack(Len(input)) as String
        Dim pos As Integer = 0

        For Each c As Char In input
            If c = "(" Or c = "[" Or c = "{" Then
                stack(pos) = c
                pos += 1
            ElseIf c = ")" Or c = "]" Or c = "}" Then
                pos -= 1

                If pos < 0 Then
                    Return False
                ElseIf c = ")" And stack(pos) <> "(" Then
                    Return False
                ElseIf c = "]" And stack(pos) <> "[" Then
                    Return False
                ElseIf c = "}" And stack(pos) <> "{" Then
                    Return False
                End If
            End If
        Next

        Return pos = 0

    End Function
End Module
