module com.ongres.saslprep {
  requires transitive com.ongres.stringprep;
  exports com.ongres.saslprep;
  provides com.ongres.stringprep.Profile with com.ongres.saslprep.SASLprep;
}