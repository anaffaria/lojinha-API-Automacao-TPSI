package pojo;

public class UserPojo {

    //obs os atributos devem estar exatamente igual a escrita do json para que o jackson databin possa converter.
    private String usuarioLogin;
    private String usuarioSenha;

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
}
