module com.ongres.saslprep {
  requires com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.saslprep.SASLprep;
}