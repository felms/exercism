// @ts-check

function Size(width = 80, height = 60) {
    this.width = width;
    this.height = height;
}

Size.prototype.resize =  function(newWidth, newHeight) {
    this.width = newWidth;
    this.height = newHeight;
}



function Position(x = 0, y = 0) {
    this.x = x;
    this.y = y;
}

Position.prototype.move = function(newX, newY) {
    this.x = newX;
    this.y = newY;
}



class ProgramWindow {
    
    constructor() {
        this.screenSize = new Size(800, 600);
        this.size = new Size();
        this.position = new Position();
    }

    resize(newSize) {
        let w = newSize.width < 1 ? 1 : newSize.width;;
        let h = newSize.height < 1 ? 1 : newSize.height;
        
        w = this.position.x + w > this.screenSize.width ? this.screenSize.width - this.position.x : w;
        h = this.position.y + h > this.screenSize.height ? this.screenSize.height - this.position.y : h;

        this.size = new Size(w,h);
    }

    move(newPosition) {
        let x = newPosition.x < 0 ? 0 : newPosition.x;
        let y = newPosition.y < 0 ? 0 : newPosition.y;

        x = x + this.size.width > this.screenSize.width ? this.screenSize.width - this.size.width : x;
        y = y + this.size.height > this.screenSize.height ? this.screenSize.height - this.size.height : y;

        this.position = new Position(x, y);
    }

}



function changeWindow(newProgramWindow) {
    let pSize = new Size(400, 300);
    let pPosition = new Position(100, 150);
    newProgramWindow.resize(pSize);
    newProgramWindow.move(pPosition);

    return newProgramWindow;
}

export {Size, Position, ProgramWindow, changeWindow};