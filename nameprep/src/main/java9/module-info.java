module com.ongres.nameprep {
  requires transitive com.ongres.stringprep;
  exports com.ongres.nameprep;
  provides com.ongres.stringprep.Profile with com.ongres.nameprep.Nameprep;
}