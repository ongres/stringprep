module com.ongres.saslprep {
  requires transitive com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.saslprep.SASLprep;
}