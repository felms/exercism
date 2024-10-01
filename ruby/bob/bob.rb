class Bob

  def self.hey(input)
    input = input.strip
    isYelling = (input.eql? input.upcase) && (not input.eql? input.downcase)
    isQuestion = input[-1].eql? "?"

    if isYelling and isQuestion
      "Calm down, I know what I'm doing!"
    elsif isYelling
      "Whoa, chill out!"
    elsif isQuestion
      "Sure."
    elsif input.empty?
      "Fine. Be that way!"
    else
      "Whatever."
    end
  end

end
