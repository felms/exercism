from strutils import rsplit

proc reverse*(s: string): string =

  for index in countdown(s.high, 0):
    result.add(s[index])
