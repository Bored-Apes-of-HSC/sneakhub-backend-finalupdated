package com.example.SpringBootRestApp.response;

public class AuthResponse {
<<<<<<< HEAD
    private String jwt;
    private String message;
    private Long id; // New field to hold the user ID
=======
	private String jwt;
	private String message;
	private Long id;

	public AuthResponse() {
	}

	public AuthResponse(String jwt, String message, Long id) {
		this.jwt = jwt;
		this.message = message;
		this.id = id;
	}
>>>>>>> c6a1e08002c6254b1c55a66f7137fe73b2f69afc

    public AuthResponse() {
    }

    public AuthResponse(String jwt, String message, Long id) {
        this.jwt = jwt;
        this.message = message;
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

<<<<<<< HEAD
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
=======
	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
>>>>>>> c6a1e08002c6254b1c55a66f7137fe73b2f69afc
