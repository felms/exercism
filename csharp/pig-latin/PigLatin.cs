using System;
using System.Linq;
using System.Text.RegularExpressions;

public static class PigLatin
{
    private static string regex = "(^[aeiou]|^xr|^y[^aeiou]).*";

    public static string Translate(string phrase) =>
        string.Join(" ", phrase.Split(" ").Select(TranslateWord));

    public static string TranslateWord(string word) 
    {
        if (Regex.IsMatch(word, regex)) {
            return word + "ay";
        }

        string newWord = Regex.IsMatch(word, "^qu.*")
                ? word.Substring(2) + "qu" 
                : word.Substring(1) + word.Substring(0, 1);

        return TranslateWord(newWord);
    }
}
