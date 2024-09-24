package java5.enumExamples;

import org.apache.commons.codec.digest.DigestUtils;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public enum ExtendingEnum implements StringOperation{
	
	  	MD5_ENCODE("Encoding the given string using the MD5 algorithm.")	{
	  		@Override
	  		public String apply(String input) {
	  			return DigestUtils.md5Hex(input);
	  		}
		},
	 
	    BASE64_ENCODE("Encoding the given string using the BASE64 algorithm.")	{
	    	@Override
	    	public String apply(String input) {
	    		return  Base64.getEncoder().encodeToString(input.getBytes());
	    	}
		},

	    BASE64_MIME("Encoding the given string using Mime encoder"){
	    		@Override
		    	public String apply(String input) {
		    		return  new String(Base64.getMimeEncoder().encode(input.getBytes()));
		    	}
	    		
	    },

	    BASE64_MIMEDECODE("Encoding the given string using Mime encoder") {
			@Override
			public String apply(String input) {
				// TODO Auto-generated method stub
				return new String(Base64.getMimeDecoder().decode(input.getBytes(StandardCharsets.UTF_16)));
			}
		};

	    private String description;
		private ExtendingEnum(String description) {
			this.description= description;
		}

		@Override
		public String getDescription() {
			return description;
		}
}
