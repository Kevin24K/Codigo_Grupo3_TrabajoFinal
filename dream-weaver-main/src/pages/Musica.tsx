import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Play, Pause } from "lucide-react";
import { useState } from "react";

const musicTracks = [
  { id: 1, title: "Lluvia Suave", duration: "30:00", type: "Naturaleza" },
  { id: 2, title: "Ondas del Océano", duration: "45:00", type: "Naturaleza" },
  { id: 3, title: "Meditación Profunda", duration: "20:00", type: "Meditación" },
  { id: 4, title: "Piano Relajante", duration: "60:00", type: "Instrumental" },
  { id: 5, title: "Bosque Nocturno", duration: "40:00", type: "Naturaleza" },
  { id: 6, title: "Viento Suave", duration: "35:00", type: "Naturaleza" },
];

const Musica = () => {
  const [playing, setPlaying] = useState<number | null>(null);

  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Música Relajante</h1>
        <p className="text-muted-foreground">Sonidos para ayudarte a dormir mejor</p>
      </div>

      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
        {musicTracks.map((track) => (
          <Card key={track.id} className="overflow-hidden">
            <CardContent className="p-0">
              <div className="aspect-square bg-gradient-to-br from-primary/20 to-primary/5 flex items-center justify-center">
                <Button
                  size="lg"
                  variant="ghost"
                  className="h-16 w-16 rounded-full bg-primary hover:bg-primary/90"
                  onClick={() => setPlaying(playing === track.id ? null : track.id)}
                >
                  {playing === track.id ? (
                    <Pause className="h-8 w-8 text-primary-foreground" />
                  ) : (
                    <Play className="h-8 w-8 text-primary-foreground" />
                  )}
                </Button>
              </div>
              <div className="p-4">
                <h3 className="font-semibold">{track.title}</h3>
                <div className="flex items-center justify-between mt-2 text-sm text-muted-foreground">
                  <span>{track.type}</span>
                  <span>{track.duration}</span>
                </div>
              </div>
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
};

export default Musica;
