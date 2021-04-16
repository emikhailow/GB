package GB7_HomeWork;

public class Plate {

    private int foodAmount;

    public Plate(int foodAmount) {

        validatePlate(foodAmount);
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    /**
     * Проверяет, хватает ли еды в миске, если да, то кот ест из нее
     * Выполняется условие, что миска не может содержать отрицательное количество еды
     *
     * @param cat
     */
    public void eat(Cat cat) {

        if (containsEnoughFood(cat)) {

            int foodAmountToDecrease = cat.getAppetite();
            this.foodAmount -= foodAmountToDecrease;
            cat.setFull(true);
            System.out.printf("Кот %s съел из миска %d еды и теперь сыт", cat.getName(), foodAmountToDecrease);
            System.out.println();

        } else {

            System.out.printf("В этой миске коту %s не хватает %d еды", cat.getName(), cat.getAppetite() - foodAmount);
            System.out.println();

        }

    }

    public void addFood(int foodAmountToAdd) {

        validatePlate(this.foodAmount + foodAmountToAdd);
        this.foodAmount += foodAmountToAdd;

    }

    public boolean containsEnoughFood(Cat cat) {
        return cat.getAppetite() <= this.foodAmount;
    }

    public void validatePlate(int foodAmount) {

        if (foodAmount < 0) {
            throw new IllegalArgumentException("Миска не может содержать отрицательное количество еды");
        }

    }

    @Override
    public String toString() {
        return "Plate{" +
                "foodAmount=" + foodAmount +
                '}';
    }
}
