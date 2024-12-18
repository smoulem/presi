class Main {
	public static void main(String[] args) {
		showSystemProps();
	}
	
	private static void showSystemProps() {
		System.getProperties().entrySet().forEach( System.out::println );
	}
}