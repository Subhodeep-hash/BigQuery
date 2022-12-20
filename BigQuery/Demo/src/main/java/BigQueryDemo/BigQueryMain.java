package BigQueryDemo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;

public class BigQueryMain{

	public static void main(String[] args) throws InterruptedException {
		 PipelineOptions option = PipelineOptionsFactory.create();
		 Pipeline p = Pipeline.create(option);
		 PCollection<String> inputCollection = p.apply(TextIO.read().from("Users/subhodghosh/Car.csv"));
		 PCollection<String> outputCollection = inputCollection.apply(MapElements.via(new Car()));
		 outputCollection.apply(TextIO.write().to("Users/subhodghosh/CarOp.csv").withHeader("Name, Number, Hash")).wait();
		 p.run().waitUntilFinish();
	}
}
