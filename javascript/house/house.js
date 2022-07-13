export class House {

    static items = [];

    static {
        this.items.push({name: '', action: ''});
        this.items.push({name: '', action: ''});
        this.items.push({name: 'the malt', 
            action: 'that lay in the house that Jack built.'});
        this.items.push({name: 'the rat', action: 'ate'});
        this.items.push({name: 'the cat', action: 'killed'});
        this.items.push({name: 'the dog', action: 'worried'});
        this.items.push({name: 'the cow with the crumpled horn', action: 'tossed'});
        this.items.push({name: 'the maiden all forlorn', action: 'milked'});
        this.items.push({name: 'the man all tattered and torn', action: 'kissed'});
        this.items.push({name: 'the priest all shaven and shorn', 
            action: 'married'});
        this.items.push({name: 'the rooster that crowed in the morn', 
            action: 'woke'});
        this.items.push({name: 'the farmer sowing his corn', action: 'kept'});
        this.items.push({name: 'the horse and the hound and the horn', 
            action: 'belonged to'});
    }

    static verse(verseNumber) {

        if (verseNumber === 1) {
            return ['This is the house that Jack built.'];
        }

        let string = 'This is ' + this.recVerse(verseNumber);
        return string.split('\n');
    }

    static verses(startVerse, endVerse) {
        let versesList = [];

        for (let i = startVerse; i <= endVerse; i++) {
            versesList.push(...this.verse(i));
            if (i < endVerse) {
                versesList.push('');
            }
        }

        return versesList;
    }

    static recVerse(number) {
        if(number === 2){
            return this.items[number].name 
                + '\n' + this.items[number].action;
        }

        return this.items[number].name 
            + '\nthat ' + this.items[number].action 
            + ' ' + this.recVerse(number - 1);
    }
}
