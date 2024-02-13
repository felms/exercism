module ProteinTranslation
  def self.proteins(strand : String) : Array(String)

    codon_to_protein = {
      "AUG" => "Methionine",
      "UUU" => "Phenylalanine",
      "UUC" =>	"Phenylalanine",
      "UUA" => "Leucine",
      "UUG" => "Leucine",
      "UCU" => "Serine",
      "UCC" => "Serine",
      "UCA" => "Serine",
      "UCG" => "Serine",
      "UAU" => "Tyrosine",
      "UAC" => "Tyrosine",
      "UGU" => "Cysteine",
      "UGC" => "Cysteine",
      "UGG" =>	"Tryptophan",
    }

    strand.chars.in_groups_of(3)
      .take_while {|codon| !codon.in?(["UAA", "UAG", "UGA"])}
      .map{ |codon| codon_to_protein.fetch(codon) {raise ArgumentError.new()} }

  end
end
