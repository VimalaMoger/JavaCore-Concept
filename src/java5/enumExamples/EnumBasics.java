package java5.enumExamples;

public enum EnumBasics implements StringOperation{
	//values

	TRIM("Removing leading and trailing spaces ")	{
	@Override
		public String apply(String input) {
			return input.trim();
		}
		},
	TO_UPPER("Changing all characters into upper case ")	{
		@Override
		public String apply(String input) {
			return input.toUpperCase();
		}
		},
	REVERSE("reversing the given string ")	{
		@Override
		public String apply(String input) {
			return new StringBuilder(input).reverse().toString();
		}
	};

	private String description;
	private EnumBasics(String description) {
		this.description = description;
		}

	@Override
	public String getDescription() {
		return description;
	}

	
	
}
