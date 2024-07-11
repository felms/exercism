Imports System

Public Class SpiralMatrix
    Public Shared Function GetMatrix(ByVal size As Integer) As Integer(,)
    
        Dim matrix(,) as Integer = New Integer(size - 1, size - 1) {}
        
        If size = 0 Then
            return matrix
        End If

        For indexI = 0 To (size - 1)
            For indexJ = 0 To (size - 1)
                matrix(indexI, indexJ) = -1
            Next
        Next
        
        Dim RIGHT_DIR as Integer = 0
        Dim DOWN_DIR as Integer = 1
        Dim LEFT_DIR as Integer = 2
        Dim UP_DIR as Integer = 3

        Dim r as Integer = 0
        Dim c as Integer = 0
        Dim direction as Integer = RIGHT_DIR

        Dim currentValue as Integer = 1
        Dim lastValue as Integer = size * size

        While currentValue <= lastValue

            matrix(r, c) = currentValue
            currentValue += 1

            If direction = RIGHT_DIR Then
                If c = (size - 1) Then
                    direction = DOWN_DIR
                    r += 1
                ElseIf matrix(r, (c + 1)) <> -1 Then
                    direction = DOWN_DIR
                    r += 1
                Else
                    c += 1
                End If
            ElseIf direction = DOWN_DIR Then
                If r = (size - 1) Then
                    direction = LEFT_DIR
                    c -= 1
                ElseIf matrix((r + 1), c) <> -1 Then
                    direction = LEFT_DIR
                    c -= 1
                Else
                    r += 1
                End If
            ElseIf direction = LEFT_DIR Then
                If c = 0 Then 
                    direction = UP_DIR
                    r -= 1
                ElseIf matrix(r, (c - 1)) <> -1 Then
                    direction = UP_DIR
                    r -= 1
                Else
                    c -= 1
                End If
            Else 'direction = UP_DIR
                If r = 0 Then
                    direction = RIGHT_DIR
                    c += 1
                ElseIf matrix((r - 1), c) <> -1 Then
                    direction = RIGHT_DIR
                    c += 1
                Else
                    r -= 1
                End If
            End If

        End While

        return matrix

    End Function
End Class
