public class Tondeuse {
    private Long positionX;
    private Long positionY;
    private String direction;
    private String instructions;

    public Tondeuse(Long positionX, Long positionY, String direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Long getPositionX() {
        return positionX;
    }

    public Long getPositionY() {
        return positionY;
    }

    public String getDirection() {
        return direction;
    }

    public String getInstructions() {
        return instructions;
    }

    public String move(Pelouse pelouse) {
        for (int i = 0; i < this.instructions.length(); i++) {
            char c = this.instructions.charAt(i);
            updateTondeuseInfos(c, pelouse);
        }
        return getInfo();
    }

    private void updateTondeuseInfos(char c, Pelouse pelouse) {
        switch (c) {
            case 'A':
                moveForwardTondeuse(pelouse);
                break;
            case 'D':
                turnRightTondeuse();
                break;
            case 'G':
                turnLeftTondeuse();
                break;
            default:
                break;
        }
    }

    private void turnLeftTondeuse() {
        switch (this.direction) {
            case "N":
                this.direction = "W";
                break;
            case "S":
                this.direction = "E";
                break;
            case "E":
                this.direction = "N";
                break;
            case "W":
                this.direction = "S";
                break;
            default:
                break;
        }
    }

    private void turnRightTondeuse() {
        switch (this.direction) {
            case "N":
                this.direction = "E";
                break;
            case "S":
                this.direction = "W";
                break;
            case "E":
                this.direction = "S";
                break;
            case "W":
                this.direction = "N";
                break;
            default:
                break;
        }
    }

    private void moveForwardTondeuse(Pelouse pelouse) {
        switch (this.direction) {
            case "N":
                if (this.positionY < pelouse.getHeight()) {
                    this.positionY += 1;
                }
                break;
            case "S":
                if (this.positionY > 0) {
                    this.positionY -= 1;
                }
                break;
            case "E":
                if (this.positionX < pelouse.getWidth()) {
                    this.positionX += 1;
                }
                break;
            case "W":
                if (this.positionX > 0) {
                    this.positionX -= 1;
                }
                break;
            default:
                break;
        }
    }

    private String getInfo() {
        return this.positionX+" "+this.positionY+" "+this.direction;
    }
}
