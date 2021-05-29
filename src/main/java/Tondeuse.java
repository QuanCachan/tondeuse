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
}
