package Lab2.Facade;

public class ShopKeeper {
    private IMobileShop iphone;
    private IMobileShop samsung;

    public ShopKeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
    }

    public void iphonePhoneSale() {
        iphone.getMobileModelNumber();
        iphone.getMobilePrice();
    }

    public void samsungPhoneSale() {
        samsung.getMobileModelNumber();
        samsung.getMobilePrice();
    }

}
