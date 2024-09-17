class PhoneNumber {

  let number: String

  init(_ number: String) {
    self.number = number
  }

  func clean() throws -> String {
    let cleaningRegex = try! Regex("\\D+")

    // 'var' to be mutable
    var num = self.number.replacing(cleaningRegex, with: "")

    if (num.count == 11 && num.first == "1") {
      num.remove(at: num.startIndex)
    }

    let validNumberRegex = #/^[2-9]\d{2}[2-9]\d{6}$/#
    if (num.firstMatch(of: validNumberRegex) != nil) {
      return num
    }

    throw PhoneNumberError.invalidPhoneNumber
  }
}

enum PhoneNumberError: Equatable, Error {

    // Throw when an invalid phone number is entered
    case invalidPhoneNumber
}
