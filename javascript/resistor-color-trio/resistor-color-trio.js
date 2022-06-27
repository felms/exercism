export class ResistorColorTrio {

    constructor(bands) {
        let colorCodes = ["black", "brown" ,"red", "orange",
                            "yellow", "green", "blue", "violet",
                            "grey", "white"];

        let value0 = colorCodes.indexOf(bands[0]);
        let value1 = colorCodes.indexOf(bands[1]);
        let zeros = colorCodes.indexOf(bands[2]);
        
        if (value0 === -1 || value1 == -1 || zeros === -1) {
            throw new Error('invalid color'); 
        }
        
        let totalValue = (value0 * 10 + value1) * Math.pow(10, zeros);
        let usedUnit = totalValue < 1000 ? 'ohms' : 'kiloohms';
        totalValue = totalValue > 1000 ? totalValue / 1000 : totalValue;

        this.label = `Resistor value: ${totalValue} ${usedUnit}`;

    }

    label() {
        return this.label;
    }
}
