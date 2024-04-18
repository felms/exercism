// @ts-check

export function Size(width = 80, height = 60) {
    this.width = width;
    this.height = height;
}

Size.prototype.resize = function(newWidth, newHeight) {
    this.width = newWidth;
    this.height = newHeight;
};

export function Position(x = 0, y = 0) {
    this.x = x;
    this.y = y;
}

Position.prototype.move = function(newX, newY) {
    this.x = newX;
    this.y = newY;
};

export class ProgramWindow {

    constructor () {
        this._screenSize = new Size(800, 600);
        this._size = new Size();
        this._position = new Position();
    }

    get screenSize() {
        return this._screenSize;
    }

    get size() {
        return this._size;
    }

    set size(newSize) {
        this._size = newSize;
    }

    get position() {
        return this._position;
    }

    set position(newPosition) {
        this._position = newPosition;
    }

    resize(newSize) {
        let newWidth = newSize.width < 1 ? 1 : newSize.width;
        newWidth = newWidth + this._position.x > this._screenSize.width 
            ? this.screenSize.width - this._position.x : newWidth;

        let newHeight = newSize.height < 1 ? 1 : newSize.height;
        newHeight = newHeight + this._position.y > this._screenSize.height 
            ? this.screenSize.height - this._position.y : newHeight;

        this._size = new Size(newWidth, newHeight);

    }

    move(newPosition) {
        let newX = newPosition.x < 0 ? 0 : newPosition.x;
        newX = newX + this._size.width > this._screenSize.width
            ? this._screenSize.width - this._size.width : newX;

        let newY = newPosition.y < 0 ? 0 : newPosition.y;
        newY = newY + this._size.height > this._screenSize.height
            ? this._screenSize.height - this._size.height : newY;

        this._position = new Position(newX, newY);
    }

}
export const changeWindow = (programWindow) => {
    programWindow.size = new Size(400, 300);
    programWindow.position = new Position(100, 150);
    return programWindow;
};
