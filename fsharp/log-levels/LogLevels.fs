module LogLevels

let message (logLine: string): string = 
    let r = logLine.Split ":"
    r[1].Trim()

let logLevel(logLine: string): string = 
    let r = logLine.Split ":"
    let r0 = r[0].Replace("[", "")
    let r1 = r0.Replace("]", "")
    r1.ToLower()

let reformat(logLine: string): string = 
    let m = message(logLine)
    let l = logLevel(logLine)

    sprintf "%s (%s)" m l