Function Get-Acronym() {
    <#
    .SYNOPSIS
    Get the acronym of a phrase.

    .DESCRIPTION
    Given a phrase, return the string acronym of that phrase.
    "As Soon As Possible" => "ASAP"
    
    .PARAMETER Phrase
    The phrase to get the acronym from.
    
    .EXAMPLE
    Get-Acronym -Phrase "As Soon As Possible"
    #>
    [CmdletBinding()]
    Param (
        [string]$Phrase
    )
    
    $array = $Phrase -replace '-|_',' ' -split '\s+'

    $result = ""

    for ($i = 0; $i -lt $array.Length; $i++) {
        $result = $result + ($array[$i].Substring(0, 1))
    }

    return $result.ToUpper()
} 
