import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Textarea } from "@/components/ui/textarea";
import { Label } from "@/components/ui/label";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
import { toast } from "sonner";

const Evaluacion = () => {
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    toast.success("Evaluación guardada exitosamente");
  };

  return (
    <div className="max-w-2xl mx-auto space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Evaluación Diaria</h1>
        <p className="text-muted-foreground">Reflexiona sobre tu día y tu descanso</p>
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Evaluación de Hoy</CardTitle>
          <CardDescription>Responde estas preguntas para mejorar tu descanso</CardDescription>
        </CardHeader>
        <CardContent>
          <form onSubmit={handleSubmit} className="space-y-6">
            <div className="space-y-3">
              <Label>¿Cómo te sientes hoy?</Label>
              <RadioGroup defaultValue="bien">
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="excelente" id="excelente" />
                  <Label htmlFor="excelente">Excelente 😄</Label>
                </div>
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="bien" id="bien" />
                  <Label htmlFor="bien">Bien 🙂</Label>
                </div>
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="regular" id="regular" />
                  <Label htmlFor="regular">Regular 😐</Label>
                </div>
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="cansado" id="cansado" />
                  <Label htmlFor="cansado">Cansado 😫</Label>
                </div>
              </RadioGroup>
            </div>

            <div className="space-y-3">
              <Label>¿Tu nivel de energía?</Label>
              <RadioGroup defaultValue="medio">
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="alto" id="alto" />
                  <Label htmlFor="alto">Alto</Label>
                </div>
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="medio" id="medio" />
                  <Label htmlFor="medio">Medio</Label>
                </div>
                <div className="flex items-center space-x-2">
                  <RadioGroupItem value="bajo" id="bajo" />
                  <Label htmlFor="bajo">Bajo</Label>
                </div>
              </RadioGroup>
            </div>

            <div className="space-y-2">
              <Label htmlFor="highlights">¿Qué fue lo mejor del día?</Label>
              <Textarea
                id="highlights"
                placeholder="Describe lo mejor de tu día..."
                className="min-h-[100px]"
              />
            </div>

            <div className="space-y-2">
              <Label htmlFor="improvements">¿Qué podrías mejorar mañana?</Label>
              <Textarea
                id="improvements"
                placeholder="¿Qué cambiarías para descansar mejor?"
                className="min-h-[100px]"
              />
            </div>

            <Button type="submit" className="w-full">
              Guardar Evaluación
            </Button>
          </form>
        </CardContent>
      </Card>
    </div>
  );
};

export default Evaluacion;
