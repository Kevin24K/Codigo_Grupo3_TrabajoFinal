package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.MusicaMultimedia;

import java.util.List;

public interface IMusicaMultimediaService
{
    public void insert(MusicaMultimedia musicaMultimedia);
    public List<MusicaMultimedia> list();
    public void delete(int id);
    public MusicaMultimedia listId(int id);
    public void update(MusicaMultimedia musicaMultimedia);
}
