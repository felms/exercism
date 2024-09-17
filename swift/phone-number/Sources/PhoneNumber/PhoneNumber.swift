class PhoneNumber {

  let number: String

  init(_ number: String) {
    self.number = number
  }

  func clean() throws -> String {
    let cleaningRegex = try! Regex("\\D+")

    // 'var' to be mutable
    var num = self.number.replacing(cleaningRegex, with: "")

    if (num.count < 10) {
      throw PhoneNumberError.invalidPhoneNumber
    }

    // Test for invalid 11 digits number (start with one)
    let elevenDigitsRegex = try! Regex("[^1]\\d{10}")
    if (num.firstMatch(of: elevenDigitsRegex) != nil) {
      throw PhoneNumberError.invalidPhoneNumber
    }

    // Remove the first digit in a 11 digit number
    let index = num.index(after: num.startIndex)
    num = num.count == 11 ? String(num[index...]) : num

    // Test for invalid area or exchange code
    let invalidAreaAndExchangeCodeRegex = try! Regex("^[01]\\d{9}$|^\\d{3}[01]\\d{6}$")
    if (num.firstMatch(of: invalidAreaAndExchangeCodeRegex) != nil) {
      throw PhoneNumberError.invalidPhoneNumber
    }

    return num
  }
}

enum PhoneNumberError: Equatable, Error {
    // Throw when an invalid phone number is entered
    case invalidPhoneNumber

    // Throw in all other cases
    case unexpected(code: Int)
}
